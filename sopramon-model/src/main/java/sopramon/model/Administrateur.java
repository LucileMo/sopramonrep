package sopramon.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="ADMIN_ID", referencedColumnName="UTIL_ID")
public class Administrateur extends Utilisateur {

}
