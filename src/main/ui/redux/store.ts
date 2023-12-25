import {configureStore} from "@reduxjs/toolkit";
import {postApi} from "./features/posts";

export const store = configureStore({
    reducer: {
        [postApi.reducerPath]: postApi.reducer
    },
    middleware: getDefaultMiddleware => {
        return getDefaultMiddleware().concat(postApi.middleware)
    }
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
