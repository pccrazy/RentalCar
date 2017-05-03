package CarRentalSystem.Pojos;

public class RentedCars {
               int CarID;
               String Username;
               String startDate;
               String endDate;

        public int getCarID() {
            return CarID;
        }

        public void setCarID(int carID) {
            CarID = carID;
        }

        public String getUsername() {
            return Username;
        }

        public void setUsername(String username) {
            Username = username;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }
}