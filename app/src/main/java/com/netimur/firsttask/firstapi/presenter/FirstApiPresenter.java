package com.netimur.firsttask.firstapi.presenter;


import com.netimur.firsttask.R;
import com.netimur.firsttask.firstapi.FirstApiContract;
import com.netimur.firsttask.utils.Constants;
import com.squareup.picasso.Picasso;

public class FirstApiPresenter implements FirstApiContract.Presenter {
    private FirstApiContract.View view;

    public FirstApiPresenter(FirstApiContract.View view) {
        this.view = view;
    }

    @Override
    public boolean lengthIsGreaterThanZero(String message) {
        if(message.length()>0)
            return true;
        else
            return false;
    }

    @Override
    public void loadPictureWithMessage(String message) {
        Picasso.with(view.getContext())
                .load(Constants.BASE_URL_FIRST_API + message)
                .placeholder(R.drawable.pic_is_loading_placeholder)
                .into(view.getBinding().imageViewFirstFragment);
    }

    @Override
    public void onClick(String message) {
        if(lengthIsGreaterThanZero(message)){
            if(connectedToNetwork(view.getContext())){
                loadPictureWithMessage(message);
            }
            else
                view.showToast(view.getContext(),view.getContext().getResources().getString(R.string.connection_error));
        }
        else
            view.showToast(view.getContext(),view.getContext().getResources().getString(R.string.zero_length_error));
    }
}
