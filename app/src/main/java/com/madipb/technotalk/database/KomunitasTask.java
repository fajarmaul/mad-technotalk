package com.madipb.technotalk.database;

import android.os.AsyncTask;

import com.madipb.technotalk.data.AnggotaEntity;
import com.madipb.technotalk.listener.BasicTaskListener;
import com.madipb.technotalk.listener.MultipleDataListener;

import java.util.ArrayList;
import java.util.List;

public class KomunitasTask {

    public static class InsertMemberTask extends AsyncTask<AnggotaEntity,Void,Boolean> {
        KomunitasDAO mAsynctaskDao;
        BasicTaskListener listener;
        public InsertMemberTask(KomunitasDAO komunitasDAO, BasicTaskListener listener) {
            mAsynctaskDao = komunitasDAO;
            this.listener = listener;
        }

        @Override
        protected Boolean doInBackground(AnggotaEntity... anggotaEntities) {
            mAsynctaskDao.insertOneMember(anggotaEntities[0]);
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            listener.onTaskFinished(aBoolean);
        }
    }

    /*Get All Member Task*/
    public static class GetAllMemberTask extends AsyncTask<Void,Void, List<AnggotaEntity>> {
        KomunitasDAO mAsynctaskDao;
        MultipleDataListener<AnggotaEntity> multipleDataListener;

        public GetAllMemberTask(KomunitasDAO komunitasDAO, MultipleDataListener<AnggotaEntity> listener) {
            mAsynctaskDao = komunitasDAO;
            this.multipleDataListener = listener;
        }

        @Override
        protected List<AnggotaEntity> doInBackground(Void... voids) {
            List<AnggotaEntity> models = new ArrayList<>();
            models = mAsynctaskDao.getAllAnggota();
            return models;
        }

        @Override
        protected void onPostExecute(List<AnggotaEntity> anggotaEntities) {
            super.onPostExecute(anggotaEntities);
            if (anggotaEntities!=null){
                if (anggotaEntities.size()!=0){
                    multipleDataListener.onSuccess(anggotaEntities, "Success Getting Data");
                } else {
                    multipleDataListener.onFailed("data is empty");
                }
            } else {
                multipleDataListener.onFailed("Failed To get Data from Database");
            }

        }
    }

}
