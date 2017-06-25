package tech.fuge.www.forgotheadfirstandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import tech.fuge.www.forgotheadfirstandroid.R;
import tech.fuge.www.forgotheadfirstandroid.fragment.WorkoutDetailFragment;
import tech.fuge.www.forgotheadfirstandroid.fragment.WorkoutListFragment;

public class WorkOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out);
        WorkoutDetailFragment fragment = (WorkoutDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_workout_details);
        //v4包使用
//        WorkoutDetailFragment fragment = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_workout_details);
        WorkoutListFragment fragment2 = (WorkoutListFragment) getFragmentManager().findFragmentById(R.id.fragment_workout_list);
        fragment.setWorkoutId(1);
    }
}
