package Student;


public class Carte implements Comparable<Carte> {
    private String titlu, autor, categorie, data,disponibilitate;

    public Carte(String titlu, String autor, String categorie, String data, String disponibilitate) {
        this.titlu = titlu;
        this.autor = autor;
        this.categorie = categorie;
        this.data = data;
        this.disponibilitate = disponibilitate;
    }

    public String getTitlu() {
        return titlu;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getData() {
        return data;
    }

    public String getDisponibilitate() {
        return disponibilitate;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDisponibilitate(String  disponibilitate) {
        this.disponibilitate = disponibilitate;
    }
    //pentru sortarea fisierului json
    public int compareTo(Carte c)
    {
        return this.getTitlu().compareTo(c.getTitlu());

        //  return this.getAutor().compareTo(c.getAutor());
    }
    public boolean equals(Object o) {
        if(o instanceof Carte)
        {
            Carte s=(Carte)o;
            return (s.getTitlu().equals(this.getTitlu()) && s.getDisponibilitate().equals(this.getDisponibilitate()));
        }

        else
            return false;
    }
    @Override
    public String toString() {
        return "Carte{" +
                "titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", categorie='" + categorie + '\'' +
                ", data='" + data + '\'' +
                ", disponibilitate='" + disponibilitate + '\'' +
                '}';
    }
}
