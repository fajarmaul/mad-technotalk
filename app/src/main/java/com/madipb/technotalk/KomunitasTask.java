package com.madipb.technotalk;

import android.os.AsyncTask;

import com.madipb.technotalk.listener.BasicTaskListener;

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

}
