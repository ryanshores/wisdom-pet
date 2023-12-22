
interface Post {
    id: Number;
    author: String;
    body: String;
    createdAt: Date;
    modifiedAt: Date;
    title: String;
}

const posts: Post[] = [
    {
        id: 1,
        title: "My thoughts on the recent events",
        body: "( ͡° ͜ʖ ͡°) I woke up just now and thought in the year of 2023\n~(˘▾˘~) that I should come write something here.\n\n¯\\_(ツ)_/¯ Excuse me if I seem unprepared...\n\n( ͡° ͜ʖ ͡°) You seeeee.ahhhh.^sneezes^.choooo\nヾ(⌐■_■)ノ♪ I was born and woke up today at 16:25:47.088227300\n~(˘▾˘~) Anyways out!",
        createdAt: new Date("2023-12-22T16:25:47.089229"),
        modifiedAt: new Date("2023-12-22T16:25:47.089229"),
        author: "Jimmy Jones"
    },
    {
        id: 2,
        title: "Title of Post 2",
        body: "This is the body of post 2",
        createdAt: new Date("2023-12-22T16:25:47.094237"),
        modifiedAt: new Date("2023-12-22T16:25:47.094237"),
        author: "Ryan Shores"
    }
]

const Posts = () => {
    return (
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Author</th>
                    <th>Body</th>
                    <th>Created At</th>
                    <th>Modified At</th>
                    <th>Title</th>
                </tr>
            </thead>
            <tbody>
            {
                posts.map(post => {
                    return (
                        <tr key={post.id.toString()} >
                            <td>{post.id.toString()}</td>
                            <td>{post.author}</td>
                            <td>{post.body}</td>
                            <td>{post.createdAt.toString()}</td>
                            <td>{post.modifiedAt.toString()}</td>
                            <td>{post.title}</td>
                        </tr>
                    )
                })
            }
            </tbody>
        </table>
    )
}

export default Posts;