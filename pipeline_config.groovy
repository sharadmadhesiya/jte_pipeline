libraries {
    ios
}
allow_scm_jenkinsfile = true 
merge = true

dev {
   
    APP_IDENTIFIER = 'com.kenvue.katalyst.demo'
    BRANCH_NAME = 'main'
    REPO_URL='sharadmadhesiya/jte_pipeline.git'
    GIT_HOST='github.com'
    PATH:'HelloWorld.xcodeproj', // Update with your project path
    CODE_SIGN_IDENTITY: 'Apple Distribution: Johnson and Johnson Consumer Services EAME Limited (D6CR985G9Q)',
    PROFILE_NAME: 'match AppStore com.kenvue.katalyst.demo', // Ensure this profile matches your provisioning profile
    SCHEME: 'HelloWorld'

}
