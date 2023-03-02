package io.datajek.databaserelationships.onetoone;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.datajek.databaserelationships.onetomany.Registration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="profile_id",referencedColumnName = "id")
    //@JsonManagedReference
    PlayerProfile playerProfile;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Registration> registrations = new ArrayList<>();

    public Player() {
    }

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, PlayerProfile playerProfile){
        super();
        this.name = name;
        this.playerProfile = playerProfile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerProfile getPlayerProfile() {
        return playerProfile;
    }

    public void setPlayerProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public void registerPlayer(Registration reg){
        registrations.add(reg);
        reg.setPlayer(this);
    }

    public void removeRegistration(Registration reg){
        if(registrations !=null)
            registrations.remove(reg);
        reg.setPlayer(null);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playerProfile=" + playerProfile +
                ", registrations=" + registrations +
                '}';
    }
}
