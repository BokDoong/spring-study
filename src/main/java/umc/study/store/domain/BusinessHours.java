package umc.study.store.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalTime;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BusinessHours {
    @Column(name = "open_time")
    private LocalTime openTime;
    @Column(name = "closed_time")
    private LocalTime closedTime;
}
