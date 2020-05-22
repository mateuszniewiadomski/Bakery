package bakery.main;

public class Logic {

    public boolean checkNames(String s) {
        if (s.length() > 1 && s.matches("[a-zA-Z]+")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPesel(String s) {
        if (s.length() != 11) {
            return false;
        } else if (s.matches("[0-9]+")) {
            int n1 = s.charAt(0) - 48;
            int n2 = s.charAt(1) - 48;
            int n3 = s.charAt(2) - 48;
            int n4 = s.charAt(3) - 48;
            int n5 = s.charAt(4) - 48;
            int n6 = s.charAt(5) - 48;
            int n7 = s.charAt(6) - 48;
            int n8 = s.charAt(7) - 48;
            int n9 = s.charAt(8) - 48;
            int n10 = s.charAt(9) - 48;
            int n11 = s.charAt(10) - 48;
            if ((n1*9+n2*7+n3*3+n4*1+n5*9+n6*7+n7*3+n8*1+n9*9+n10*7) % 10 == n11) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public String setBirthDate(String s) {
        int n1 = s.charAt(0) - 48;
        int n2 = s.charAt(1) - 48;
        int n3 = s.charAt(2) - 48;
        int n4 = s.charAt(3) - 48;
        int n5 = s.charAt(4) - 48;
        int n6 = s.charAt(5) - 48;
        int y = n3*10+n4;
        if (y > 80 && y <=92) {
            return "18"+n1+""+n2+"-"+n3+""+n4+"-"+n5+""+n6;
        } else if (y > 0 && y <= 12) {
            return "19"+n1+""+n2+"-"+n3+""+n4+"-"+n5+""+n6;
        } else if (y > 20 && y <=32) {
            return "20"+n1+""+n2+"-"+n3+""+n4+"-"+n5+""+n6;
        } else if (y > 40 && y <= 52) {
            return "21"+n1+""+n2+"-"+n3+""+n4+"-"+n5+""+n6;
        } else {
            return "22"+n1+""+n2+"-"+n3+""+n4+"-"+n5+""+n6;
        }
    }

    public boolean checkBirthDate(String s) {
        if (s.matches("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setGender(String s) {
        if ((s.charAt(9)-48) % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkTelephone(String s) {
        if (s.length() == 9 && s.matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkNumber(String s) {
        if (s.matches("[1-9][0-9]*")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPostalCode(String s) {
        if (s.matches("[0-9][0-9]-[0-9][0-9][0-9]")) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkImage(String s) {
        if (s.equals("cow") || s.equals("Cow") || s.equals("COW")) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkUsername(String s) {
        if (s.length() >=  3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPassword(String s) {
        if (s.length() >= 4) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPrice(String s) {
        if (s.matches("[0-9]*")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkProductName(String s) {
        if (s.matches("[A-Za-z]*")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkProductToBake(String s) {
        if (s.matches("[0-9]*")) {
            if (s.matches("[0][0-9]+")) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
