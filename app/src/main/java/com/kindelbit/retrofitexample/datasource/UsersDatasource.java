package com.kindelbit.retrofitexample.datasource;

import com.kindelbit.retrofitexample.models.User;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by josemarmagalhaes on 6/6/16.
 */
public class UsersDatasource {
    private Realm realm;

    public UsersDatasource(Realm realm) {
        this.realm = realm;
    }

    public void save(final User user) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(user);
            }
        });
    }

    public List<User> getUsers() {
        return realm.where(User.class).findAll();
    }

    public User getUser(String id) {
        return realm.where(User.class).equalTo("id", id).findFirst();
    }

    public void save(final List<User> users) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(users);
            }
        });
    }

    public void replaceAll(final List<User> users) {
        final RealmResults<User> results = realm.where(User.class).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                results.deleteAllFromRealm();
                realm.copyToRealmOrUpdate(users);
            }
        });

    }

}
