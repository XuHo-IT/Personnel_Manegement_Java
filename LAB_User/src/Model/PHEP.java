    package Model;

    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Date;
    import java.util.List;
    import java.util.Scanner;

    import static Model.NHANSU.nhansuList;


    public class PHEP  {
        public static List<PHEP> listPhep= new ArrayList<>();
        protected byte ID_Phep;
        protected byte ID_nhanSu;
        protected String noiDung;
       protected Date ngay_dangKi;
       protected Date start_ngayPhep;
       protected Date end_ngayPhep;
        protected String bound;
        protected String noi_nghi;

        public PHEP(byte ID_Phep, byte ID_nhanSu, String noiDung, Date ngay_dangKi, Date start_ngayPhep, Date end_ngayPhep, String bound, String noi_nghi) {
            this.ID_Phep = ID_Phep;
            this.ID_nhanSu = ID_nhanSu;
            this.noiDung = noiDung;
            this.ngay_dangKi = ngay_dangKi;
            this.start_ngayPhep = start_ngayPhep;
            this.end_ngayPhep = end_ngayPhep;
            this.bound = bound;
            this.noi_nghi = noi_nghi;
        }

        public byte getID_Phep() {
            return ID_Phep;
        }

        public void setID_Phep(byte ID_Phep) {
            this.ID_Phep = ID_Phep;
        }

        public byte getID_nhanSu() {
            return ID_nhanSu;
        }

        public void setID_nhanSu(byte ID_nhanSu) {
            this.ID_nhanSu = ID_nhanSu;
        }

        public String getNoiDung() {
            return noiDung;
        }

        public void setNoiDung(String noiDung) {
            this.noiDung = noiDung;
        }

        public Date getNgay_dangKi() {
            return ngay_dangKi;
        }

        public void setNgay_dangKi(Date ngay_dangKi) {
            this.ngay_dangKi = ngay_dangKi;
        }

        public Date getStart_ngayPhep() {
            return start_ngayPhep;
        }

        public void setStart_ngayPhep(Date start_ngayPhep) {
            this.start_ngayPhep = start_ngayPhep;
        }

        public Date getEnd_ngayPhep() {
            return end_ngayPhep;
        }

        public void setEnd_ngayPhep(Date end_ngayPhep) {
            this.end_ngayPhep = end_ngayPhep;
        }

        public String getBound() {
            return bound;
        }

        public void setBound(String bound) {
            this.bound = bound;
        }

        public String getNoi_nghi() {
            return noi_nghi;
        }

        public void setNoi_nghi(String noi_nghi) {
            this.noi_nghi = noi_nghi;
        }

        public boolean checkIDNhanSuExists(byte id) {
            for (NHANSU nhansu : nhansuList) {
                if (nhansu.getID_NhanSu() == id) {
                    return true;
                }
            }
            return false;
        }
        public boolean checkString (String temp){
            for (PHEP phep: listPhep){
                if (phep.getNoiDung().equals(temp)){
                    return false;
                }
            }
            return true;
        }

        public void setPHEPList(List<PHEP> nhansuList) {
            listPhep= nhansuList;
        }

        public  void addPHEP(PHEP phep) {
            listPhep.add(phep);
        }


        public  void removePHEP(byte id) {
            for (PHEP phep : listPhep) {
                if (phep.getID_Phep()==id){
                    listPhep.remove(phep);
                }
            }

        }


        public  PHEP getHOCById(byte id) {
            for (PHEP phep : listPhep) {
                if (phep.getID_nhanSu()== id) {
                    return phep;
                }
            }
            return null;
        }

        public void printAllPHEP() {
            for (PHEP phep : listPhep) {
                System.out.println(phep);
            }
        }

        public PHEP add(){
            PHEP newPhep = new PHEP();
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            boolean validID = false;
            do {
                try {
                    System.out.println("Enter ID_nhanSu: ");
                    newPhep.ID_nhanSu = sc.nextByte();
                    sc.nextLine();

                    if (checkIDNhanSuExists(newPhep.getID_nhanSu())) {
                        validID = true;
                    } else {
                        throw new IllegalArgumentException("Error: ID_nhanSu does not exist in NHANSU list.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!validID);

            System.out.println("Enter ID_phep: ");
           newPhep.ID_Phep = sc.nextByte();
            sc.nextLine();

            boolean temp = false;
            do {
                try {
                    System.out.println("Enter Noi_dung: ");
                    newPhep.noiDung = sc.nextLine();
                    if (checkString(newPhep.getNoiDung())) {
                        temp = true;
                    } else {
                        throw new IllegalArgumentException("Error: Noi dung is overlapping .");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!temp);


            Date date1 = null;
            while (date1 == null) {
                System.out.println("Enter ngay dang ki (yyyy-MM-dd): ");
                String dateString = sc.nextLine();

                try {
                    date1 = dateFormat.parse(dateString);
                    newPhep.ngay_dangKi = date1;
                    System.out.println("Parsed Date: " + date1);
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
                }
            }


            Date date2 = null;
            while (date2 == null) {
                System.out.println("Enter ngay  phep bat dau (yyyy-MM-dd): ");
                String dateString = sc.nextLine();

                try {
                    date2 = dateFormat.parse(dateString);
                    newPhep.start_ngayPhep = date2;
                    System.out.println("Parsed Date: " + date2);
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
                }
            }


            Date date3 = null;
            while (date3 == null) {
                System.out.println("Enter ngay  phep dung lai (yyyy-MM-dd): ");
                String dateString = sc.nextLine();

                try {
                    date3 = dateFormat.parse(dateString);
                    newPhep.end_ngayPhep = date3;
                    System.out.println("Parsed Date: " + date3);
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
                }
            }

            System.out.println("Enter Bound:");
            newPhep.bound = sc.nextLine();

            System.out.println("Enter noi nghi:");
            newPhep.noi_nghi = sc.nextLine();
            addPHEP(newPhep);
            return newPhep;
        }

        @Override
        public String toString() {
            return "PHEP: " +
                    "ID_Phep: " + ID_Phep +
                    ", ID_nhanSu: " + ID_nhanSu +
                    ", noiDung: " + noiDung+
                    ", ngay_dangKi: " + ngay_dangKi +
                    ", start_ngayPhep: " + start_ngayPhep +
                    ", end_ngayPhep: " + end_ngayPhep +
                    ", bound: " + bound  +
                    ", noi_nghi; " + noi_nghi;

        }

        public PHEP() {
        }
    }
