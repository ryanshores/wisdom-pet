import {createApi, fetchBaseQuery} from "@reduxjs/toolkit/query/react";
import {PostObject} from "../../models/PostObject";
import {PayloadAction} from "@reduxjs/toolkit";

export const postApi = createApi({
    reducerPath: 'api',
    baseQuery: fetchBaseQuery({
        baseUrl: `http://localhost:8080/api/posts`
    }),
    endpoints(build) {
        return {
            fetchAll: build.query<PostObject[], void>({
                query: () => ""
            }),
            fetchById: build.query<PostObject, string>({
                query: id => `/${id}`
            })
        }
    }
});

export const { useFetchAllQuery, useFetchByIdQuery } = postApi;