package com.l.gui;

public interface Contract {
    interface View {
        void showData(String data);

        void showError(String errorMessage);

        void showProgress(boolean isContinued);
    }

    interface Presenter {
        void onReady();
    }
}
