public class UserName {
    String value;

    public UserName(String value){
        if (value == null)
            throw new IllegalArgumentException("value is required");
        else if (!isValid(value))
            throw new IllegalArgumentException("invalid value");

        this.value = value;
    }

    private boolean isValid(String value){
        if (value.isEmpty())
            return false;

        return value.trim() == value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserName userName = (UserName) o;

        return value.equals(userName.value);

    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
