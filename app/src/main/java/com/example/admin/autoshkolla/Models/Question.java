package com.example.admin.autoshkolla.Models;

import java.util.List;

/**
 * Created by herolindsopjani on 11/23/16.
 */

public class Question {
    public int id;
    public int name;
    public int exam_id;
    public int points;

    public List<Alternative> alternatives;

}
