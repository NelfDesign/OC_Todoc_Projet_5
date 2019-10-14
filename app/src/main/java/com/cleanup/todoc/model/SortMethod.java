package com.cleanup.todoc.model;

/**
 * Created by Nelfdesign at 11/10/2019
 * com.cleanup.todoc.model
 */
public enum SortMethod {
    /**
     * Sort alphabetical by name
     */
    ALPHABETICAL,
    /**
     * Inverted sort alphabetical by name
     */
    ALPHABETICAL_INVERTED,
    /**
     * Lastly created first
     */
    RECENT_FIRST,
    /**
     * First created first
     */
    OLD_FIRST,
    /**
     * No sort
     */
    NONE
}
