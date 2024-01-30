package umc.study.store.domain.location;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.store.domain.Store;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "region")
    private List<Store> stores = new ArrayList<>();

    @Builder
    public Region(String name) {
        this.name = name;
        this.stores = new ArrayList<>();
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public static String extractTown(String address) {
        String pattern = "(\\p{IsHangul}+\\s*\\p{IsHangul}*구).*";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(address);

        if (matcher.matches()) {
            return matcher.group(1);
        } else {
            return "No match";
        }
    }
}
