node {
    stage('Checkout'){
        print "Checkout goes"
        git 'https://github.com/httpEugene/react-todolist.git'
    }
    
    stage('Test'){
    
     env.NODE_ENV = "test"
    
     print "Environment will be : ${env.NODE_ENV}"
    
     sh 'node -v'
     sh 'npm prune'
     sh 'npm install'
     sh 'npm build'
    
    }
    
    stage('Build Docker'){
        echo 'Build Docker'
        // sh './dockerBuild.sh'
    }
    
    stage('Deploy'){
    
     echo 'Push to Repo'
    //  sh './dockerPushToRepo.sh'
    
    //  echo 'ssh to web server and tell it to pull new image'
    //  sh 'ssh deploy@xxxxx.xxxxx.com running/xxxxxxx/dockerRun.sh'
    
    }
    
    stage('Cleanup'){
    
     echo 'prune and cleanup'
     sh 'npm prune'
     sh 'rm node_modules -rf'
    
    //  mail body: 'project build successful',
    //              from: 'xxxx@yyyyy.com',
    //              replyTo: 'xxxx@yyyy.com',
    //              subject: 'project build successful',
    //              to: 'yyyyy@yyyy.com'
    }
}