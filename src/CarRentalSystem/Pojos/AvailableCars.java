package CarRentalSystem.Pojos;

public class AvailableCars {
        int CarID;
        String company;
        String name;
        int model;
        String type;
        int maxPassenger;

        public int getCarID() {
            return CarID;
        }

        public void setCarID(int carID) {
            this.CarID = carID;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getModel() {
            return model;
        }

        public void setModel(int model) {
            this.model = model;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getMaxPassenger() {
            return maxPassenger;
        }

        public void setMaxPassenger(int maxPassenger) {
            this.maxPassenger = maxPassenger;
        }
    }