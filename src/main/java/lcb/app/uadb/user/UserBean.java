package lcb.app.uadb.user;

import java.time.LocalDateTime;

public class UserBean {

    private int id;

    private String user_id;
    private String lastName;
    private String firstName;
    private String role;
    private String username;
    private String email;
    private String password;
    private String service;
    private String poste;
    private String agency;
    private int status;
    private String city;
    private String zone;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private String pwdID;

    public UserBean(int id, String user_id, String lastName, String firstName, String role, String username, String email, String password,
                    String service, String poste, String agency, int status, String city, String zone, LocalDateTime createdAt,
                    LocalDateTime updateAt, String pwdID
    ) {
        this.id = id;
        this.user_id = user_id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.role = role;
        this.username = username;
        this.email = email;
        this.password = password;
        this.service = service;
        this.poste = poste;
        this.agency = agency;
        this.status = status;
        this.city = city;
        this.zone = zone;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.pwdID = pwdID;
    }

    public UserBean(String lastName, String firstName, String role, String username, String email, String password, String
            service, String poste, String agency, int status, String city, String zone, LocalDateTime createdAt, LocalDateTime updateAt,
                    String pwdID
    ) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.role = role;
        this.username = username;
        this.email = email;
        this.password = password;
        this.service = service;
        this.poste = poste;
        this.agency = agency;
        this.status = status;
        this.city = city;
        this.zone = zone;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.pwdID = pwdID;
    }

    public UserBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getPwdID() {
        return pwdID;
    }

    public void setPwdID(String pwdID) {
        this.pwdID = pwdID;
    }

    public String getUserID() {
        return this.user_id;
    }

    public void setUserID(String user_id) {
        this.user_id = user_id;
    }
}
