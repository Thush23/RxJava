package com.example.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.tvResult);

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(Observable.just(1, 2, 3, 4, 5)
                .filter(value -> value % 2 == 0)
                .map(value -> value * value)
                .map(value -> "Number: " + value)
                .map(value -> Integer.parseInt(value))
                .subscribe(newValue -> {
                    String oldvalue = textView.getText().toString();
                    textView.setText(oldvalue + newValue + "\n"); },
                        throwable -> textView.setText(throwable.toString())));
        //disposable.dispose();

     /* Observable.just("Hello")
              .map(value -> Integer.parseInt(value))
              .map(value -> value.toString())
              .subscribe(new Observer<String>() {
                  @Override
                  public void onSubscribe(Disposable d) {
                      String oldvalue = textView.getText().toString();
                    textView.setText(oldvalue + "Subscribed" + "\n");
                  }
                  @Override
                  public void onNext(String newvalue) {
                      String oldvalue = textView.getText().toString();
                      textView.setText(oldvalue + newvalue + "\n");
                  }
                  @Override
                  public void onError(Throwable e) {
                      String oldvalue = textView.getText().toString();
                      textView.setText(oldvalue + e.toString() + "\n");
                  }

                  @Override
                  public void onComplete() {
                      String oldvalue = textView.getText().toString();
                      textView.setText(oldvalue + "Subscribed" + "\n");
                  }
              });

       /* Observable.just(1, 2, 3, 4, 5)//CAN BE MODIFIED
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer % 2 == 0;
                    }
                })
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer * integer;
                    }
                })
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "Number: " + String.valueOf(integer);
                    }
                })
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) throws Exception {
                        return Integer.parseInt(s);
                    }
                })
                .subscribe(new Consumer<Integer>() {//CANNOT BE MODIFIED AFTER! Works as onSuccess
                    @Override
                    public void accept(Integer newValue) throws Exception {
                        String oldvalue = textView.getText().toString();
                        textView.setText(oldvalue + newValue + "\n");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {//Works as onFailure
                        textView.setText(throwable.toString());
                    }
                });
    }*/
    }
}
