import React, {useEffect, useState} from 'react';
import {PostObject} from "../models/PostObject";
import {useFetchByIdQuery} from "../redux/features/posts";
import {useParams} from "react-router";
import {Link} from "react-router-dom";

const NoPost = () => (
    <div>
        <h5>Post not found...</h5>
        <Link to='/'>Take me home...</Link>
    </div>
);

const Post = () => {
    const [post, setPost] = useState<PostObject>();
    const { id } = useParams();

    if (id === undefined) return <NoPost />;

    const {data, isFetching} = useFetchByIdQuery(id);

    useEffect(() => {
        if (isFetching || !data) return;
        setPost(data);
    }, [data, isFetching])

    return post ?
        <div>
            <h5>{post.title}</h5>
            <p>Created on: {post.createdAt.toString()}</p>
            <p>{post.body}</p>
        </div> : <NoPost />
}

export default Post;