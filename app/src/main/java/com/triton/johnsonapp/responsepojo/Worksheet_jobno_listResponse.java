package com.triton.johnsonapp.responsepojo;

import java.util.List;

public class Worksheet_jobno_listResponse {
    private String Status;
    private String Message;
    private int Code;
    private List<DataBean> Data;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        private String _id;
        private String activedetail__id;
        private String job_detail_no;
        private String job_detail_created_at;
        private String job_detail_update_at;
        private String job_detail_created_by;
        private String job_detail_updated_by;
        private String update_reason;
        private int __v;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getActivedetail__id() {
            return activedetail__id;
        }

        public void setActivedetail__id(String activedetail__id) {
            this.activedetail__id = activedetail__id;
        }

        public String getJob_detail_no() {
            return job_detail_no;
        }

        public void setJob_detail_no(String job_detail_no) {
            this.job_detail_no = job_detail_no;
        }

        public String getJob_detail_created_at() {
            return job_detail_created_at;
        }

        public void setJob_detail_created_at(String job_detail_created_at) {
            this.job_detail_created_at = job_detail_created_at;
        }

        public String getJob_detail_update_at() {
            return job_detail_update_at;
        }

        public void setJob_detail_update_at(String job_detail_update_at) {
            this.job_detail_update_at = job_detail_update_at;
        }

        public String getJob_detail_created_by() {
            return job_detail_created_by;
        }

        public void setJob_detail_created_by(String job_detail_created_by) {
            this.job_detail_created_by = job_detail_created_by;
        }

        public String getJob_detail_updated_by() {
            return job_detail_updated_by;
        }

        public void setJob_detail_updated_by(String job_detail_updated_by) {
            this.job_detail_updated_by = job_detail_updated_by;
        }

        public String getUpdate_reason() {
            return update_reason;
        }

        public void setUpdate_reason(String update_reason) {
            this.update_reason = update_reason;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }
    }
}
