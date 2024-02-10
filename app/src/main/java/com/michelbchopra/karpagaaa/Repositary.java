package com.michelbchopra.karpagaaa;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Repositary extends RoomDatabase {

    private final ContactDAO contactDAO;
    ExecutorService executorService;

    Handler handler;

    protected Repositary(Application application) {


        ContactDatabase contactDatabase = ContactDatabase.getInstance(application);
        this.contactDAO =contactDatabase.getCantactDAO();
        executorService = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }

    public void addcontact(Contact contact) {


        executorService.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.insert(contact);
            }
        });


    }

    public void deletecontact(Contact contact) {

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.delete(contact);
            }
        });

    }

    public LiveData<List<Contact>> getallcontacts() {
        return contactDAO.getallcontacts();
    }
}
