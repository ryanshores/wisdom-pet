import {configureStore} from "@reduxjs/toolkit";
import {postApi} from "./features/posts";
import {app} from "./features/app";

export const store = configureStore({
    reducer: {
        "app" : app.reducer,
        "postApi" : postApi.reducer
    },
    middleware: getDefaultMiddleware => {
        return getDefaultMiddleware().concat(postApi.middleware)
    }
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
