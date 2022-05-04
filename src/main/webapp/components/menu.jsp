<div class="header">
  <div class="header-left">
  </div>
  <div class="header-right">
    <div class="dashboard-setting user-notification">
      <div class="dropdown">
        <a class="dropdown-toggle no-arrow" href="javascript:;" data-toggle="right-sidebar">
          <i class="dw dw-settings2"></i>
        </a>
      </div>
    </div>
    <div class="user-notification">
      <div class="dropdown">
        <a class="dropdown-toggle no-arrow" href="#" role="button" data-toggle="dropdown">
          <i class="icon-copy dw dw-notification"></i>
          <span class="badge notification-active"></span>
        </a>
        <div class="dropdown-menu dropdown-menu-right">
          <div class="notification-list mx-h-350 customscroll">
            <ul>
              <li>
                <a href="#">
                  <img src="vendors/images/photo3.jpg" alt="">
                  <h3>John Doe</h3>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed...</p>
                </a>
              </li>
              <li>
                <a href="#">
                  <img src="vendors/images/photo4.jpg" alt="">
                  <h3>Renee I. Hansen</h3>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed...</p>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="user-info-dropdown">
      <div class="dropdown">
        <a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown">
          <span class="user-name"><%= user.getFirstName() + " " + user.getLastName() %></span>
        </a>
        <div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
          <a class="dropdown-item" href="profile.html"><i class="dw dw-user1"></i> Profile</a>
          <a class="dropdown-item" href="profile.html"><i class="dw dw-settings2"></i> Paramètres</a>
          <a class="dropdown-item" href="faq.html"><i class="dw dw-help"></i> Aide</a>
          <a class="dropdown-item" href="login.html"><i class="dw dw-logout"></i> Déconnexion</a>
        </div>
      </div>
    </div>
  </div>
</div>
