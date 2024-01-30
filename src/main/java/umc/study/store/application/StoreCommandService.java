package umc.study.store.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.exception.BusinessException;
import umc.study.exception.code.ErrorCode;
import umc.study.store.application.dto.StoreCommandMapper;
import umc.study.store.application.dto.StoreCreateCommand;
import umc.study.store.domain.Store;
import umc.study.store.domain.StoreRepository;
import umc.study.store.domain.location.Region;
import umc.study.user.domain.UserRepository;
import umc.study.user.domain.info.Category;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreCommandService {

    private final StoreCommandMapper storeCommandMapper;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Transactional
    public void creatStore(StoreCreateCommand storeCreateCommand) {
        // 1. 주소 찾기 -> 없으면 추가
        Region region = findOrCreateRegion(storeCreateCommand.getRegionAddress());
        // 2. Region + Category(찾아서) 생성
        Category category = findFoodCategory(storeCreateCommand.getCategoryId());
        // 3. save
        Store store = storeCommandMapper.toEntity(storeCreateCommand, category, region);
        region.addStore(store);
        category.addStore(store);
        storeRepository.save(store);
    }

    private Region findOrCreateRegion(String regionName) {
        Optional<Region> region = storeRepository.findRegion(regionName);
        if (region.isEmpty()) {
            Region newRegion = new Region(regionName);
            saveRegion(newRegion);
            return newRegion;
        } else {
            return region.get();
        }
    }

    private void saveRegion(Region region) {
        storeRepository.save(region);
    }

    private Category findFoodCategory(Long categoryId) {
        return userRepository.findCategoryById(categoryId)
                .orElseThrow(() -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));
    }
}
