package gitlet;

import java.io.File;
import java.time.*;

import static gitlet.Utils.*;


// TODO: any imports you need here

/**
 * Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 * @author RobinYe
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /**
     * The current working directory.
     */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /**
     * The .gitlet directory.
     */
    public static final File GITLET_DIR = join(CWD, ".gitlet");

    /* TODO: fill in the rest of this class. */

    /**
     * Initializes a new gitlet repository.
     * There is no return value.
     */
    public static void init() {
        if (GITLET_DIR.mkdir()) {
        System.err.println("A Gitlet version-control system already exists in the current directory.");
        } // Create the dir.

        String hash = gitlet.Utils.sha1(GITLET_DIR);
        ZonedDateTime zonedDateTime = Commit.convertInstantToZonedDateTime(java.time.Instant.now());
        String initCommit = "initial commit";
        String branch = "master";

        Commit commit = new Commit(); // Create a Commit Tree.

        commit.add(hash, zonedDateTime, initCommit, branch);
    }

    public static void add(String file) {
        // TODO
    }

    public static void commit(String message) {
        // TODO
        // Invoke Commit class
    }

    public static void rm(String file) {
        // TODO
        System.err.println("No reason to remove the file.");
    }

    public static void log() {
        // TODO
    }

    public static void globalLog() {
        // TODO
        // A useful method in Utils.
    }

    public static void find() {
        // TODO
    }

    public static void status() {
        // TODO
    }

    public static void checkout() {
        // TODO
    }


    public static void branch(String branch) {
        // TODO
    }

    public static void rmBranch(String branch) {
        // TODO
    }

    public static void reset(String commitID) {
        // TODO
    }

    public static void merge(String branch) {
        // TODO
    }
}