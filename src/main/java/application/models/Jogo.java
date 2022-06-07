package application.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Set;
import java.util.HashSet;
@Entity
@Table(name="jogos")
public class Jogo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String titulo;

    @ManyToOne
    @JoinColumn(name="id_genero")
    private Genero genero;

    @ManyToMany
    @JoinTable(
        name = "jogos_possuem_plataformas",
        joinColumns = @JoinColumn(name = "jogos_id"),
        inverseJoinColumns=@JoinColumn(name="plataformas_id"))
    
    private Set<Plataforma> plataformas = new HashSet<>();

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
  
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public Set<Plataforma> getPlataformas() {
        return plataformas;
    }
    public void setPlataformas(Set<Plataforma> plataformas) {
        this.plataformas = plataformas;
    }
 
    
}