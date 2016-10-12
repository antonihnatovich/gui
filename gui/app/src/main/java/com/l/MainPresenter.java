package com.l;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.l.backend.unusualName.UnusualName;
import com.l.gui.Contract;

public class MainPresenter implements Contract.Presenter{
    private Contract.View view;
    private Handler handler;

    public MainPresenter(@NonNull Contract.View view){
        this.view = view;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onReady() {
        view.showProgress(true);
        loadData();
    }

    private void loadData(){
        new Thread(){
            @Override
            public void run(){
                try {
                    UnusualName.GetStats call = ApiManager.get().trainingsApi().getStats();
                    String response = call.execute().getData();
                    notifyResponce(response);
                } catch (Exception e){
                    e.printStackTrace();
                    notifyError(e);
                }

            }
        };
    }

    private void notifyError(final Throwable e) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                view.showProgress(false);
                view.showError(e.getMessage());
            }
        });
    }

    private void notifyResponce(final String response) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                view.showProgress(false);
                view.showData(response);
            }
        });
    }
}
