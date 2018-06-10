package src.main.java.engine;
import java.util.Map;
import java.util.TreeMap;
import java.time.LocalDate;

public class TreeHash {
    private Map<Long, Post> postTree;
    private long contadorR;
    private long contadorP;
    private LocalDate creationDate;

    public TreeHash() {
        this.postTree = new TreeMap <Long, Post>();
        this.contadorR = 0;
        this.contadorP = 0;
    }

    public TreeHash(TreeMap<Long, Post> postTree, long contadorR, long contadorP, LocalDate creationDate) {
        this.postTree = new TreeMap <Long, Post>();
        if(postTree!=null) setPostTree(postTree);
        this.contadorR = contadorR;
        this.contadorP = contadorP;
        this.creationDate = creationDate;
    }

    public TreeHash(TreeHash a) {
        this.postTree = a.getPostTree();
        this.contadorR = a.getContadorR();
        this.contadorP = a.getContadorP();
        this.creationDate = a.getCreationDate();
    }

    public Map<Long, Post> getPostTree(){
        Map<Long, Post> neo = new TreeMap<Long, Post>();
        for(Map.Entry<Long, Post> entry : this.postTree.entrySet()){
            neo.put(entry.getKey(), entry.getValue());
        }
        return neo;
    }

    private void setPostTree(Map<Long, Post> utilizadores) {
        this.postTree = new TreeMap<Long, Post>();
        for(Map.Entry<Long, Post> entry: utilizadores.entrySet())
            this.postTree.put(entry.getKey(), entry.getValue().clone());
    }

    public long getContadorR() {
        return contadorR;
    }

    public void setContadorR(long contadorR) {
        this.contadorR = contadorR;
    }

    public long getContadorP() {
        return contadorP;
    }

    public void setContadorP(long contadorP) {
        this.contadorP = contadorP;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this. creationDate = creationDate;
    }

    public void addTreeMap(Post p){
        this.postTree.put(p.getId(),p);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        TreeHash p = (TreeHash) o;
        return this.contadorP == p.getContadorP() && p.getContadorR() == this.contadorR &&
                 p.getPostTree().equals(this.postTree) && p.getCreationDate().equals(this.creationDate);
    }

}