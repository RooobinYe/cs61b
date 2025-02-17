package gitlet;

// TODO: any imports you need here

import java.time.*;
import java.util.LinkedList;

/**
 * Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 * @author RobinYe
 */
public class Commit {
    /**
     * TODO: add instance variables here.
     * <p>
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    private String message;
    private int commitVersion;


    public class CommitNode {
        String hash;
        ZonedDateTime time;
        String message;
        String branch;

        /**
         * Constructs a CommitNode with the given parameters.
         *
         * @param h the unique hash representing the commit.
         * @param t the time when the commit was made.
         * @param m the commit message summarizing the changes.
         * @param b the branch of the commit.
         */
        CommitNode(String h, ZonedDateTime t, String m, String b) {
            this.hash = h;
            this.time = t;
            this.message = m;
            this.branch = b;
        }
    }

    /* TODO: fill in the rest of this class. */

    LinkedList<CommitNode> Commit = new LinkedList<>(); // CommitNode can be ignored

//    public CommitNode createCommit(String h, ZonedDateTime d, String m, String b) {
//        return new CommitNode(h, d, m, b);
//    }

    /**
     * Return a time with zone info.
     *
     * @return ZonedDateTime the time with zone info.
     */
    public ZonedDateTime getTime() {
        return java.time.ZonedDateTime.now();
    }

    /**
     * Display the time.
     * Format: week month hh:mm:ss year zone
     *
     * @param zoneDateTime
     * @return
     */
    public ZonedDateTime displayLocalTime(ZonedDateTime zoneDateTime) {
        return null;
    }

    /**
     * As its name. This function is used to convert time.
     *
     * @param instant
     */
    public static ZonedDateTime convertInstantToZonedDateTime(Instant instant) {
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId);
    }

    /**
     * Add CommiteNode to the Commit.
     * Commite is a TREE.
     *
     * @param h hash.
     * @param t time.
     * @param m massage.
     * @param b branch name
     */
    public void add(String h, ZonedDateTime t, String m, String b) {
        CommitNode cn = new CommitNode(h, t, m, b);
        Commit.add(cn);
    }

//    public void createBranch(String branch) {
//
//    }

}