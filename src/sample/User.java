package sample;

public class User {

        private String id;
        private String FIO;
        private String auditorium;
        private String comment;
        private String device;
        private String date;
        private String status;


        public User(String FIO, String auditorium, String device, String comment, String date, String status, String id) {
            this.id = id;
            this.FIO = FIO;
            this.auditorium = auditorium;
            this.comment = comment;
            this.device = device;
            this.date = date;
            this.status = status;

        }

        public User() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFIO() {
            return FIO;
        }

        public void setFIO(String FIO) {
            this.FIO = FIO;
        }

        public String getAuditorium() {
            return auditorium;
        }

        public void setAuditorium(String auditorium) {
            this.auditorium = auditorium;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getDevice() {
            return device;
        }

        public void setDevice(String device) {
            this.device = device;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
}