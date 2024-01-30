package umc.study.store.domain.review.image;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Embeddable
public class Images {

    @OneToMany(mappedBy = "review")
    private final List<ReviewImage> reviewImages;

    protected Images() {
        this.reviewImages = new LinkedList<>();}

    List<ReviewImage> getImages() {
        return Collections.unmodifiableList(reviewImages);
    }
}
