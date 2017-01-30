package co.tenton.admin.autoshkolla.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by herolindsopjani on 11/24/16.
 */

public class This {
    public static This shared = new This();
    public List<Exam> exams = new ArrayList<Exam>();
    public List<Group> groups = new ArrayList<Group>();
    public List<Subgroup> subgroups = new ArrayList<>();
    public List<Sign> illustraions = new ArrayList<>();

    public Integer version = 0;
}
