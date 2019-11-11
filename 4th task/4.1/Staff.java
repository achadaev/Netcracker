public class Staff extends Person {
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Staff[Person[" +
                "name='" + super.getName() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                "], school='" + school + '\'' +
                ", pay=" + pay +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;
        if (!super.equals(o)) return false;

        Staff staff = (Staff) o;

        if (Double.compare(staff.pay, pay) != 0) return false;
        return school.equals(staff.school);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + school.hashCode();
        temp = Double.doubleToLongBits(pay);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
