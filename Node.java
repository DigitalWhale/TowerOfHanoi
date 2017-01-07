

public class Node { //Each node represents a move number.
    private Node parent = new Node(), left = new Node(), right = new Node();
    public int indexMove, indexRod, indexRing;

    //Create node. It defines where the ring
    public void create(Node parent, boolean sideBranch, int[] currentRods){// if sideBranch == false, then this left branch, else - right branch;
        this.parent = parent;
        indexRing = this.parent.indexRing - 1;
        if(sideBranch){//right branch
            indexMove = parent.indexMove + (int)Math.pow(2, indexRing)/2;
            indexRod = parent.indexRod;
        }
        else{ //Left branch
            indexMove = parent.indexMove - (int)Math.pow(2, indexRing)/2;
            //indexRod != current rod where the ring & indexRod != parent.indexRod;
            indexRod = 3 - currentRods[indexRing] - parent.indexRod;
        }
        currentRods[indexRing] = indexRod;


        if(indexRing != 0){
            left.create(this, false, currentRods);
            right.create(this, true, currentRods);
        }
    }

    //Create start node. It defines where the ring
    public void create(int countRing, int endIndexRod, int[] currentRods){
        parent = null;
        indexRing = countRing - 1;
        indexMove = (int)Math.pow(2, indexRing + 1)/2;
        indexRod = endIndexRod;
        currentRods[indexRing] = indexRod;
        if(indexRing != 0){
            left.create(this, false, currentRods);
            right.create(this, true, currentRods);
        }
    }

}
