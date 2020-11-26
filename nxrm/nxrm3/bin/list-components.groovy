import groovy.json.JsonSlurper
import groovy.json.JsonOutput;

class NXRM3Components {

   static void main(String[] args) {

      def fmt = args[0]

      def repositoryUrl = 'http://localhost:8081'
      def repositoryName = 'staging-development'

      def endpoint = repositoryUrl + '/service/rest/v1/components'
      def query = '?repository=' + repositoryName
      def repoAddress = endpoint + query

      def continueToken = 'start'
      int numberOfComponents = 0
      println ''

      while (continueToken != null){

         def url = new URL(repoAddress)
         def connection = url.openConnection()

         connection.requestMethod = 'GET'
         connection.setRequestProperty("Authorization", "Basic YWRtaW46YWRtaW4xMjM=")

         if (connection.responseCode == 200) {
            def content = connection.content.text

            def jsonSlurper = new JsonSlurper()
            def jsonObject = jsonSlurper.parseText(content)

            jsonObject.items.each { 

               switch(fmt){
                  case 'ids': printIds(it); break
                  case 'assets': printAssets(it); break
                  case 'raw': printRaw(it); break
                  default: printIds(it); break
               }

               numberOfComponents++
            }

            continueToken = jsonObject.continuationToken

            if (continueToken != null){
               repoAddress = endpoint + query + '&continuationToken=' + continueToken
            } 
         }
      }
      println ''
      println  repositoryName + ' (' + repositoryUrl + ') - number of components: ' + numberOfComponents
      println ''
   }

   static printIds(it){

      def listing

      if (it.format == 'maven2'){
         listing = it.group + '.' + it.name + ':' + it.version + ' (' + it.id + ')'
      }
      else {
         listing = it.name + ':' + it.version + ' (' + it.id + ')'
      }

      println listing
   }

   static printAssets(it){
      
      printIds(it)

      println ' - Assets'
      for (asset in it.assets){
         println '  -- ' + asset.downloadUrl // + ' (' + asset.id + ')'
      }
   }

   static def printRaw(it){
      def pretty = JsonOutput.toJson(it)
      println pretty
   }
   
}





