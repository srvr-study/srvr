package kr.kro.srvrstudy.srvr_main.domain.model;

public enum FeatureServerStatus {

    ENABLED(1), DEVELOPING(2), DISABLED(3);

    private final int value;

    FeatureServerStatus(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
