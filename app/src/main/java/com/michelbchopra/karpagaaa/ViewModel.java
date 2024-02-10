package com.michelbchopra.karpagaaa;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {


    private Repositary repositary;
    public ViewModel(@NonNull Application application,Repositary repositary) {
        super(application);
        this.repositary = repositary;
    }

    private LiveData<List<Contact>> allContacts;



    public LiveData<List<Contact>> getAllContacts(){
        allContacts = repositary.getallcontacts();

        return allContacts;

    }

    public void addnewContact(Contact contact){
        repositary.addcontact(contact);
    }


    public void removecontact(Contact contact){
        repositary.deletecontact(contact);
    }

}
