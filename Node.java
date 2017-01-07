
public class Node { //Each node represents a move number.
    private Node parent, left, right;
    public int indexMove, indexRod, indexRing;


    //Create node. It defines where the ring
    public void create(Node parent, boolean sideBranch, int[] currentRods){// if sideBranch == false, then this left branch, else - right branch;
        this.parent = parent;
        indexRing = this.parent.indexRing-1;
        if(sideBranch){//right branch
            indexMove = parent.indexMove + (int)Math.pow(2, indexRing)/2;
            indexRod = parent.indexRod;
        }
        else{ //Left branch
            indexMove = parent.indexMove - (int)Math.pow(2, indexRing)/2;
            //indexRod != current rod where the ring & indexRod != parent.indexRod;
            indexRod = 3 - currentRods[indexRing - 1] - parent.indexRod;
        }
        currentRods[indexRing - 1] = indexRod;

        System.out.println("indexMove " + indexMove + ", indexRing " + indexRing + ", indexRod " + indexRod);

        if(indexRing != 1){
            left = new Node();
            right = new Node();
            left.create(this, false, currentRods);
            right.create(this, true, currentRods);
        }
    }

    //Create start node. It defines where the ring
    public void create(int countRing, int endIndexRod, int[] currentRods){
        parent = null;
        indexRing = countRing;
        indexMove = (int)Math.pow(2, indexRing)/2;
        indexRod = endIndexRod;

        System.out.println("indexMove " + indexMove + ", indexRing " + indexRing + ", indexRod " + indexRod);

        currentRods[indexRing - 1] = indexRod;
        if(indexRing != 1){
            left = new Node();
            right = new Node();
            left.create(this, false, currentRods);
            right.create(this, true, currentRods);
        }
    }

}
