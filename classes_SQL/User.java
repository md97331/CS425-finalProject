package classesSQL;

public class User {
    private String id;
    private String password;
    private String admin;
    private int menuOption;
    private int subMenuOption;

    public User(String id, String password, String admin, int menuOption, int subMenuOption) {
        this.id = id;
        this.password = password;
        this.admin = admin;
        this.menuOption = menuOption;
        this.subMenuOption = subMenuOption;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public int getMenuOption() {
        return menuOption;
    }

    public void setMenuOption(int menuOption) {
        this.menuOption = menuOption;
    }

    public int getSubMenuOption() {
        return subMenuOption;
    }

    public void setSubMenuOption(int subMenuOption) {
        this.subMenuOption = subMenuOption;
    }
}
