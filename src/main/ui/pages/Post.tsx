import React, {useEffect, useState} from 'react';
import {PostObject} from "../models/PostObject";
import {useFetchByIdQuery} from "../redux/features/posts";
import {redirect, useParams} from "react-router";


const Post = () => {
    const [post, setPost] = useState<PostObject>();
    const { id } = useParams();

    if (!id) return redirect("/");

    const {data, isFetching} = useFetchByIdQuery(id);

    useEffect(() => {
        if (isFetching || !data) return;
        setPost(data);
    }, [data, isFetching])

    return (
        <>
            <h4>Post</h4>
            {
                post ?
                    <div>
                        <h5>{post.title}</h5>
                        <p>Created on: {post.createdAt.toString()}</p>
                        <p>{post.body}</p>
                    </div> : null
            }
        </>
    )
}

export default Post;