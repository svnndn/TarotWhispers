function toggleLike(postId) {
    fetch('/posts/like/' + postId, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (response.ok) {
                const likeIcon = document.getElementById('likeIcon_' + postId);
                const unlikeIcon = document.getElementById('unlikeIcon_' + postId);
                if (likeIcon.style.display === 'none') {
                    likeIcon.style.display = 'inline';
                    unlikeIcon.style.display = 'none';
                } else {
                    likeIcon.style.display = 'none';
                    unlikeIcon.style.display = 'inline';
                }
            } else {
                alert('Failed to like/unlike the post.');
            }
        })
        .catch(error => {
            alert('Error: ' + error);
        });
}