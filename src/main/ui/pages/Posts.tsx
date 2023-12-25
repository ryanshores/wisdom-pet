import React, {useLayoutEffect, useState} from "react";
import {PostObject} from "../models/PostObject";
import {useFetchAllQuery} from "../redux/features/posts";
import {Card, CardBody, CardFooter, CardHeader, CardImg, CardLink, Col, Row} from "reactstrap";

const PostElement = ({post}: {post: PostObject}) => {
    return (
        <Card>
            <CardHeader>
                <CardLink href={`/posts/${post.id}`}>{post.title}</CardLink>
            </CardHeader>
            <CardBody>
                {post.body}
            </CardBody>
            <CardFooter>By: {post.author} on {post.createdAt.toString()}</CardFooter>
        </Card>
    )
}

const Posts = () => {
    const [posts, setPosts] = useState<PostObject[]>();
    const { data, isFetching } = useFetchAllQuery();

    useLayoutEffect(() => {
        if (isFetching || !data) return;

        setPosts(data);
    }, [data, isFetching]);

    const postElements = posts ?
        posts.map(post => <Col>
            <PostElement post={post} />
        </Col>) : null;

    return (
        <>
            <h1>Posts</h1>
            <Row>{postElements}</Row>
        </>
    )
}

export default Posts;