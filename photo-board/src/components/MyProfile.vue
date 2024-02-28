<template>
  <!-- My Profile -->
  <div class="container">
            <div class="white-box">
                <div id="title" class="box-title"><p>My Profile</p></div>
                <div class="division-line"></div>
                <div id="content" class="box-content">
                    <img src="../assets/icon/profile.png" width="40%" class="profile-img">
                    <button type="button" id="myprofile-btn"></button>
                    <div>
                        <div class="content content-name">
                            <p>Name</p>
                            <input type="text">
                        </div>
                        <div class="content content-email">
                            <p>Email</p>
                            <input type="email">
                        </div>
                        <div class="content content-phone">
                            <p>Phone</p>
                            <input type="number">
                        </div>
                        <div class="content content-about">
                            <p>About</p>
                            <textarea></textarea>
                        </div>
                    </div>
                  </div>
                </div>
              </div>
</template>

<script>
export default {

}
</script>

<style>
/* My Profile */
.container {
  position: absolute;
  display: flex;
  align-items: center;
  background-color: #F5F5F7;
  width: 100%;
  height: 100%;
}
.white-box {
  position: absolute;
  vertical-align: middle;
  left: 10%;
  right: 0;
  margin: auto;
  width: 80%;
  height: 70%;
  background: white;
  padding: 40px;
  border-radius: 10px;
}
.box-title {
  position: absolute;
  top: 10px;
  font-size: 30px;
}
.division-line {
  border-top: 1px solid #dcdfe3;
  margin-top: 55px; 
}
.box-content {
  padding-top: 40px;
  width: 100%;  
  height: 70%;
}
.profile-img {
  position: absolute;
  top: 80px;
}
.content {
    position: absolute;
    top: 120px;
}

.content-name {
    left: 600px;
}

.content-email {
    left: 900px;
}

.content-phone {
    left: 600px;
    top: 250px;
}

.content-about {
    left: 600px;
    top: 380px;
}
input {
    width: 200px;
    height: 30px;;
    font-size: 15px;
    border: 0;
    border-bottom: 1.5px solid #D3D3D3;
}
textarea {
    width: 520px;
    height: 100px;
    font-size: 15px;
    border: 0;
    background-color: #F5F5F7;
    border-radius: 10px;
    padding: 15px 0 0 20px;
}
.myprofile-btn {
    position: absolute;
    top: 410px;
    left: 350px;
    height: 50px;
    width: 50px;
    border-radius: 50%;
    border: 0;
    background-color: white;
    background-image: url("../assets/icon/camera.png");
    background-size: 60%;
    background-repeat: no-repeat;
    background-position: center;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
}
.myprofile-btn:hover {
  opacity: 0.7; 
}
</style>