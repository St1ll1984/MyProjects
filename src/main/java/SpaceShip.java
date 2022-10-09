public class SpaceShip {

        private String name;
        private String serialNumber;

        public String getSerialNumber() {
            return name;
        }

        public void setSerialNumber(String serialNumber) {
            if (serialNumber.length() != 8 || !serialNumber.startsWith("SN")) {
                return;
            }

            this.serialNumber = serialNumber;
        }




        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name.isBlank() || name.length() > 100) {
                return;
            }

            this.name = name;
        }

        //Test output
        public static void main(String[] args) {
            SpaceShip ship = new SpaceShip();

            ship.setSerialNumber("SN506788");
            System.out.println(ship.getSerialNumber()); //Should be SN506788

            ship.setSerialNumber("EE123456");
            System.out.println(ship.getSerialNumber()); //Should be SN506788 - old value
        }



}
