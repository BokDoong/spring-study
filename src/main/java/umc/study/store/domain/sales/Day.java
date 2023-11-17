package umc.study.store.domain.sales;

public enum Day {
    MON("월요일"), TUE("화요일"), WED("수요일"), THUR("목요일"),
    FRI("금요일"), SAT("토요일"), SUN("일요일");

    private final String value;

    Day(String value) {
        this.value = value;
    }
}
