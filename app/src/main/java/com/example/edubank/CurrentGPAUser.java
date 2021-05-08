package com.example.edubank;

public class CurrentGPAUser {
    private static CurrentGPAUser currentGPAUser = null;
    private long maxId = 0;
    private CurrentGPAUser() {}

    public static CurrentGPAUser getInstance() {
        if (currentGPAUser == null)
            currentGPAUser = new CurrentGPAUser();

        return currentGPAUser;
    }

    public long getMaxId() {
        return maxId;
    }

    public void setMaxId(long maxId) {
        this.maxId = maxId;
    }
}
