package type;
import java.util.Objects;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        if(o == this) {
            return true;
        }
        if(o instanceof TreeNode) {
            TreeNode t = (TreeNode) o;
            return Objects.equals(val, t.val) && Objects.equals(left, t.left) && Objects.equals(right, t.right);
        }
        return false;
    }
}